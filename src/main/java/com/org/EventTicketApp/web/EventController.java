/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.web;

import com.org.EventTicketApp.Services.JsonService;
import com.org.EventTicketApp.entities.Event;
import com.org.EventTicketApp.entities.TicketHelper;
import com.org.EventTicketApp.repo.EventRepo;
import com.org.EventTicketApp.repo.TicketHelperRepo;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.net.MalformedURLException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import static org.springframework.hateoas.mediatype.alps.Alps.ext;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author DEEV
 */
@RestController
@CrossOrigin(origins ="http://localhost:3000" )
public class EventController {
    @Autowired
    private EventRepo eventrepo;
    @Autowired
    private TicketHelperRepo tickerhRepo;
    @Autowired
	   JsonService eventService;
    @GetMapping("/events")
    public Iterable<Event> getEvents(){
    return eventrepo.findAll();
 }
    
    @GetMapping("/events/{id}")
    public Optional<Event> getEventById(@PathVariable("id") Long id){
    return eventrepo.findById(id);
 }
    @GetMapping("/events/public/{id}")
    List<Event[]> getpublicEvents(@PathVariable("id") Long id){
        return eventrepo.FindpublicEvents(id);
    }
     @GetMapping("/events/private/{id}")
    List<Event[]> getprivateEvents(@PathVariable("id") Long id){
        return eventrepo.FindprivateEvents(id);
    }

    @PostMapping(
            path = "/events/save",
          consumes = { MediaType.APPLICATION_JSON_VALUE,
                       MediaType.MULTIPART_FORM_DATA_VALUE })
    public Event CreateEvent(@RequestPart("Event") String  event,@RequestPart("file") MultipartFile file) {
        //event.setCustomTicket(tickerhRepo.save(event.getCustomTicket()));
        String filename = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), file.getOriginalFilename());
        Path filepath = Paths.get("src/main/resources/LogoImages/", filename);
            Event eventJson = eventService.getJson(event);
            TicketHelper th = eventJson.getCustomTicket();
            System.out.println(th.getLogo());
            th.setLogo("http://localhost:8080/api/image/"+filename);
            System.out.println(th.getLogo());
            eventJson.setCustomTicket(th);
            
        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
             return eventrepo.save(eventJson);
        } catch (IOException e) {
            System.out.println("error here");
            return null;
        }
       
    }
        @GetMapping(path = "/api/image/{imgName}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public UrlResource getImage(@PathVariable("imgName") String imgName) throws IOException {
        Path pathToFile = FileSystems.getDefault().getPath("src/main/resources/LogoImages/" + imgName);
        UrlResource resource = null;
        try {
            resource = new UrlResource(pathToFile.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return resource;
    }


    
}

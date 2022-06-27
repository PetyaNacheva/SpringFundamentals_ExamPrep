package musicdb.web;

import musicdb.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final AlbumService albumService;

    public HomeController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/")
    public String home( HttpSession httpSession, Model model){

        if(httpSession.getAttribute("username")==null){
            return "index";
        }
        model.addAttribute("allAlbums", albumService.getAllAlbums());
        model.addAttribute("totalCopies", albumService.getAllCopies());

        return "home";
    }
}

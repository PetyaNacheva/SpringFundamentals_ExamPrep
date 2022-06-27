package musicdb.web;

import musicdb.model.UserEntity;
import musicdb.model.binding.AlbumBindingModel;
import musicdb.model.service.AlbumServiceModel;
import musicdb.service.AlbumService;
import musicdb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper, UserService userService) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession){
        if(httpSession.getAttribute("username")==null){
            return "redirect:/users/login";
        }
        if(!model.containsAttribute("albumBindingModel")){
            model.addAttribute("albumBindingModel", new AlbumBindingModel());

        }
        return "add-album";
    }

    @PostMapping("/add")
    public String addConfirmed(@Valid AlbumBindingModel albumBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpSession httpSession){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("albumBindingModel", albumBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumBindingModel", bindingResult);

            return "redirect:add";
        }


        UserEntity user = userService.findUserByUsernameAndEmail(httpSession.getAttribute("username").toString(), httpSession.getAttribute("email").toString());

        albumService.addAlbum(modelMapper.map(albumBindingModel, AlbumServiceModel.class), user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        albumService.deleteAlbum(id);
        return "redirect:/";
    }

}

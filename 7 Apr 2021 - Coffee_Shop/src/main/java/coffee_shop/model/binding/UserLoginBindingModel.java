package coffee_shop.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {
    private Long id;
    @NotBlank(message = "username must be filled")
    @Size(min = 3, max = 20, message = "username must be between 3 and 20 chars")
    private String username;
    @NotBlank(message = "password must be filled")
    @Size(min = 3, max = 20, message = "password must be between 3 and 20 chars")
    private String password;

    public UserLoginBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

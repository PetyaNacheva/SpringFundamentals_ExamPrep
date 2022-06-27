package coffee_shop.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    private Long id;
    @NotBlank(message = "usenrame is required")
    @Size(min = 5, max = 20, message = "username must be between2 and 20 chars")
    private String username;
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 20, message = "last name must be between 5 and 20 chars")
    private String lastName;
    @Email(message = "email must be correct")
    @NotBlank(message = "email is required")
    private String email;
    @NotBlank(message = "password is required")
    @Size(min = 3, message = "password must be more than 3")
    private String password;
    @NotBlank(message = "password is required")
    @Size(min = 3, message = "password must be more than 3")
    private String confirmPassword;

    public UserRegisterBindingModel() {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

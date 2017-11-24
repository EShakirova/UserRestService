package entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel( value = "User", description = "User resource representation" )
public class User {
    @ApiModelProperty( value = "User's name", required = true )
    private String name;
    @ApiModelProperty( value = "User's login", required = true )
    private String login;
    @ApiModelProperty( value = "User's password", required = true )
    private String password;
    @ApiModelProperty( value = "User's birthdate", required = true )
    private String birthday;
    @ApiModelProperty( value = "User's sex", required = true )
    private Sex sex;

    public User(String name, String login, String password, String birthday, Sex sex) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.birthday = birthday;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}

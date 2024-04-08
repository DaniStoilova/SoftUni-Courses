package softuni.exam.domain.dto;

import javax.validation.constraints.NotEmpty;

public class PictureBase {


    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

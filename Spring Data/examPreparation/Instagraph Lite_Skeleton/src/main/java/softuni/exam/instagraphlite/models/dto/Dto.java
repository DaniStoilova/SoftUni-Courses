package softuni.exam.instagraphlite.models.dto;

import softuni.exam.instagraphlite.models.entity.Post;

import java.util.Set;

public class Dto {

    private String username;

    private Set<Post> posts;

    private PostBase post;

    private PictureDTO picture;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public PostBase getPost() {
        return post;
    }

    public void setPost(PostBase post) {
        this.post = post;
    }

    public PictureDTO getPicture() {
        return picture;
    }

    public void setPicture(PictureDTO picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        String FORMAT = "User: %s\n" +
                "Post count: %d\n" +
                "==Post Details:\n" +
                "----Caption: %s\n" +
                "----Picture Size: %.2f\n";

        return String.format(FORMAT,
                this.username,
                this.posts.size(),
                this.post.getCaption(),
                this.picture.getSize()

        );

    }
}

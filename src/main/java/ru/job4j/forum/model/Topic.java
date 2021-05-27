package ru.job4j.forum.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String desc;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
    @OneToMany(mappedBy = "topic")
    private List<Comment> comments;

    public Topic() {
    }

    public static Topic of(Integer id, String name, List<Comment> comments, Post post) {
        Topic topic = new Topic();
        topic.id = id;
        topic.name = name;
        topic.comments = comments;
        topic.post = post;
        return topic;
    }

    public void addComment(Comment comment) {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(comment);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}

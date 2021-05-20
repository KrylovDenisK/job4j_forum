package ru.job4j.forum.model;
import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String desc;
    @OneToMany(mappedBy = "post")
    private List<Topic> topics;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "author_id")
    private User author;

    public static Post of(Integer id, String name, List<Topic> topics) {
        Post post = new Post();
        post.id = id;
        post.name = name;
        post.topics = topics;
        return post;
    }

    public void addTopic(Topic topic) {
        if (topics == null) {
            topics = new ArrayList<>();
        }
        topics.add(topic);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id
                && Objects.equals(name, post.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
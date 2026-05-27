package ForumIntegration;

import java.util.ArrayList;
import java.util.List;

public class ForumPost {
    private int id;
    private String author;
    private String title;
    private String content;
    private List<String> comments;

    public ForumPost(int id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.comments = new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public List<String> getComments() { return comments; }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public void displayPost() {
        System.out.println("=== " + title + " ===");
        System.out.println("Author: " + author);
        System.out.println("Content: " + content);
        if (!comments.isEmpty()) {
            System.out.println("Comments:");
            for (String c : comments) {
                System.out.println("  - " + c);
            }
        }
    }
}

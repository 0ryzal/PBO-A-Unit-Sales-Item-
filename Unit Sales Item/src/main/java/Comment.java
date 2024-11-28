public class Comment {
    private String author;
    private String text;
    private int rating;
    private int voteCount;

    public Comment(String author, String text, int rating) {
        this.author = author;
        this.text = text;
        this.rating = Math.max(0, Math.min(rating, 5));
        this.voteCount = 0;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public int getRating() {
        return rating;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void upvote() {
        voteCount++;
    }

    public void downvote() {
        voteCount--;
    }

    public String getFullDetails() {
        return "Author: " + author + "\n" +
               "Rating: " + rating + "/5\n" +
               "Votes: " + voteCount + "\n" +
               "Comment: " + text;
    }
}

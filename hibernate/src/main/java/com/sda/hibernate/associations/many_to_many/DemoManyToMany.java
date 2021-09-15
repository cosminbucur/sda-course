package com.sda.hibernate.associations.many_to_many;

public class DemoManyToMany {

    public static void main(String[] args) {
        PostDao postDao = new PostDao();

        Tag tag1 = new Tag();
        tag1.setName("tag1");

        Tag tag2 = new Tag();
        tag2.setName("tag2");

        Post post1 = new Post();
        post1.setTitle("post1");

        Post post2 = new Post();
        post1.setTitle("post2");

        // add two tags to post 1
        post1.addTag(tag1);
        post1.addTag(tag2);

        // add one tag to post 2
        post2.addTag(tag2);

        // save posts
        postDao.create(post1);
        postDao.create(post2);
    }
}

<template>
  <div>
    <div style="display: flex; flex-wrap: wrap">
      <CardPost v-for="post in posts" :key="post.id" :post="post" />
    </div>

    <button @click="fetchPosts">Fetch Post</button>
  </div>
</template>

<script>
import CardPost from "@/components/CardPost";

export default {
  name: "Posts",
  components: {
    CardPost,
  },
  data() {
    return {
      posts: [],
      baseURI: "https://jsonplaceholder.typicode.com/posts",
    };
  },
  methods: {
    fetchPosts: function () {
      this.$http.get(this.baseURI).then((result) => {
        // console.log(result);
        this.posts = result.data.filter((post) => post.id % 2 != 0);
      });
    },
  },
};
</script>

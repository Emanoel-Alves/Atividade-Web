<template>
  <div>
    <div style="display: flex; flex-wrap: wrap">
      <CardComment
        v-for="comment in comments"
        :key="comment.id"
        :comment="comment"
      />
    </div>

    <button @click="fetchComments">Fetch Comments</button>
  </div>
</template>

<script>
import CardComment from "@/components/CardComment";
export default {
  name: "Comments",
  components: {
    CardComment,
  },
  data() {
    return {
      comments: [],
      baseURI: "https://jsonplaceholder.typicode.com/comments",
    };
  },
  methods: {
    fetchComments: function () {
      this.$http.get(this.baseURI).then((result) => {
        console.log(result);
        this.comments = result.data.filter((comment) => comment.id % 2 == 0);
      });
    },
  },
};
</script>

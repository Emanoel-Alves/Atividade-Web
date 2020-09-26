<template>
  <div>
    <div class="card bg-light mb-3 cardComment">
      <div class="card-header"><strong>ID: </strong>{{ comment.id }}</div>
      <div class="card-body">
        <h4 class="card-title">Post ID: {{ comment.postId }}</h4>
        <p class="card-text"><strong>Name: </strong> {{ comment.name }}</p>
        <p class="card-text"><strong>Email: </strong>{{ comment.email }}</p>
        <p class="card-text"><strong>Body: </strong>{{ comment.body }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CardComment",
  props: {
    comment: {},
  },
};
</script>

<style scoped>
.cardComment {
  width: 18rem;
  height: 26rem;
  margin-left: 30%;
}
</style>

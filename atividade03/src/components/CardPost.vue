<template>
  <div>
    <div class="card bg-light mb-3 cardPost">
      <div class="card-header"><strong>ID: </strong>{{ post.id }}</div>
      <div class="card-body">
        <!-- <h5 >Light card title</h5> -->
        <h4 class="card-title">User ID: {{ post.userId }}</h4>
        <p class="card-text"><strong>Title: </strong> {{ post.title }}</p>
        <p class="card-text"><strong>Body: </strong> {{ post.body }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CardPost",
  props: {
    post: {},
  },
};
</script>

<style scoped>
.cardPost {
  width: 18rem;
  height: 26rem;
  margin-left: 30%;
}
</style>

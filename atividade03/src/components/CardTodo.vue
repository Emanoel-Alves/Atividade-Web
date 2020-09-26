<template>
  <div>
    <div v-show="todo.completed" class="card bg-light mb-3 cardTodos" style="">
      <div class="card-header"><strong>ID: </strong> {{ todo.id }}</div>
      <div class="card-body">
        <!-- <h5 >Light card title</h5> -->
        <h4 class="card-title">User ID: {{ todo.userId }}</h4>
        <p class="card-text"><strong>Title: </strong>{{ todo.title }}</p>
        <p class="card-text">
          <strong>Completed: </strong>{{ todo.completed }}
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CardTodo",
  props: {
    todo: {},
  },
};
</script>

<style scoped>
.cardTodos {
  width: 18rem;
  height: 17rem;
  margin-left: 30%;
}
</style>

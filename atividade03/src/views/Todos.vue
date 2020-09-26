<template>
  <div>
    <div style="display: flex; flex-wrap: wrap">
      <CardTodo v-for="todo in todos" :key="todo.id" :todo="todo" />
    </div>

    <button @click="fetchTodos">Fetch Todos</button>
  </div>
</template>

<script>
import CardTodo from "@/components/CardTodo";

export default {
  name: "Todos",
  components: {
    CardTodo,
  },
  data() {
    return {
      todos: [],
      baseURI: "https://jsonplaceholder.typicode.com/todos",
    };
  },
  methods: {
    fetchTodos: function () {
      this.$http.get(this.baseURI).then((result) => {
        // console.log(result);
        this.todos = result.data.filter((todo) => todo.userId == 2);
      });
    },
  },
};
</script>

<template>
  <div class="home">
    <Atividade msg="Atividade 03 de web" />
  </div>
</template>

<script>
// @ is an alias to /src
import Atividade from "@/views/Atividade.vue";

export default {
  name: "Home",
  components: {
    Atividade,
  },
};
</script>

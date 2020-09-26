<template>
  <div class="logo">
    <img alt="Vue logo" src="../assets/logo.png" />
    <h1>{{ msg }}</h1>
  </div>
</template>

<script>
export default {
  name: "Atividade",
  props: {
    msg: String,
  },
};
</script>

<style scoped>
.logo {
  display: flex;
  flex-direction: row;
  align-items: center;
  text-align: center;
  margin-left: 35%;
  margin-top: 10%;
}
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
img {
  width: 100px;
}
</style>

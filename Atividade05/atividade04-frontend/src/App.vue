<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/cadastrar">Cadastrar Carro</router-link> |
      <router-link to="/listagem">Listar Carros</router-link> |
      <router-link to="/buscar">Buscar Carro</router-link> |
      <router-link to="/deletar">Deletar Carro</router-link> |
      <router-link to="/atualizar">Atualizar Carro</router-link> |
      <router-link to="/filtrar-marca">Filtrar por Marca</router-link> |
      <router-link to="/filtrar-quantidade">Filtrar por Quantidade</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>

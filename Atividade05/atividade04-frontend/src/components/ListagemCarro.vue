<template>
  <div class="listagem">
    <h1>Listar</h1>

    <button type="button" @click="getCarros()" class="btn btn-primary">
      Cadastrar Carro
    </button>

    <div style="width: 90%">
      <div
        style="
          margin-top: 20px;
          border: solid 1px;
          border-color: #111;
          padding-top: 13px;
        "
        v-for="carro in carros"
        :key="carro.id"
      >
        <p>
          <strong>ID: </strong> {{ carro.id }} <strong>Nome: </strong>
          {{ carro.nome }} <strong>Marca: </strong> {{ carro.marca }}
          <strong>Ano de Frabicação: </strong> {{ carro.anoFabricacao }}
          <strong>Ano do Modelo: </strong> {{ carro.anoModelo }}
          <strong>Data de Venda: </strong> {{ carro.dataVenda }}
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CadastrarCarro",
  data() {
    return {
      carros: {},
      baseURI: "http://localhost:8080/api/carros",
    };
  },
  methods: {
    getCarros() {
      this.$http.get(this.baseURI).then((result) => {
        this.carros = result.data;
      });
    },
  },
};
</script>

<style>
.listagem {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}
</style>
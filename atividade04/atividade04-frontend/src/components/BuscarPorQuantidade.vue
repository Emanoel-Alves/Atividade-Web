<template>
  <div class="filtrar">
    <h1>Filtrar carros por quantidade</h1>
    <div class="centralizar">
      <form style="width: 100%">
        <div class="form-group">
          <label for="quant">Quantidade</label>
          <input
            v-model="quantidade"
            type="text"
            class="form-control"
            id="quant"
            placeholder="5..."
          />
        </div>
        <button type="button" @click="filterCarro()" class="btn btn-primary">
          Filtrar Carros
        </button>
        <div v-if="carros !== null" style="width: 100%">
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
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "BuscarPorQuantidade",
  data() {
    return {
      quantidade: "",
      carros: null,
      baseURI: "http://localhost:8080/atividade04-backend/api/carros",
    };
  },
  methods: {
    filterCarro() {
      this.$http
        .get(this.baseURI + "/?quantidade=" + this.quantidade)
        .then((result) => {
          this.carros = result.data;
          console.log(this.carros);
        });
    },
  },
};
</script>

<style scoped>
.filtrar {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}
.centralizar {
  width: 50%;
}
</style>
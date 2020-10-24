<template>
  <div class="filtrar">
    <h1>Filtrar carros por marca</h1>
    <div class="centralizar">
      <form style="width: 100%">
        <div class="form-group">
          <label for="marca">Marca *tal e qual ta no banco</label>
          <input
            v-model="marca"
            type="text"
            class="form-control"
            id="marca"
            placeholder="Corola..."
          />
        </div>
        <button type="button" @click="filterCarro()" class="btn btn-primary">
          Filtrar Carro
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
  name: "BuscarPorMarca",
  data() {
    return {
      marca: "",
      carros: null,
      baseURI: "http://localhost:8080/api/carros",
     
    };
  },
  methods: {
    filterCarro() {
      this.$http.get(this.baseURI + "/searchMrc?marca=" + this.marca).then((result) => {
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
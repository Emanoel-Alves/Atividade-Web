<template>
  <div class="deletar">
    <h1>Deletar Carro</h1>
    <div class="centralizar">
      <form style="width: 100%">
        <div class="form-group">
          <label for="id">ID do Carro</label>
          <input
            v-model="idCarro"
            type="text"
            class="form-control"
            id="id"
            placeholder="1..."
          />
        </div>
        <button type="button" @click="deleteCarro()" class="btn btn-danger">
          Deletar Carro
        </button>
        <div v-if="deletado && idCarro !== ''" style="width: 100%">
          <div
            style="
              margin-top: 20px;
              border: solid 1px;
              border-color: #111;
              padding-top: 13px;
            "
          >
            <p>
              <strong>Carro deletado</strong>
            </p>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "DeletarCarro",
  data() {
    return {
      idCarro: "",
      deletado: false,
      baseURI: "http://localhost:8080/api/carros",
    };
  },
  methods: {
    deleteCarro() {
      this.$http.delete(this.baseURI + "/" + this.idCarro).then((result) => {});
      this.deletado = true;
    },
  },
};
</script>

<style scoped>
.deletar {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}
.centralizar {
  width: 50%;
}
</style>
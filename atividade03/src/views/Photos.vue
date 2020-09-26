<template>
  <div>
    <div class="CardPhoto">
      <div v-for="photo in photos" :key="photo.id">
        <img style="width: 100px; margin: 5px" :src="photo.url" alt="" />
      </div>
    </div>

    <button @click="fetchPhotos">Fetch Photos</button>
  </div>
</template>

<script>
export default {
  name: "Photos",
  data() {
    return {
      photos: [],
      baseURI: "https://jsonplaceholder.typicode.com/photos",
    };
  },
  methods: {
    fetchPhotos: function () {
      this.$http.get(this.baseURI).then((result) => {
        // console.log(result);
        this.photos = result.data.filter((photo) => photo.albumId == 3);
      });
    },
  },
};
</script>

<style scoped>
.CardPhoto {
  display: flex;
  flex-wrap: wrap;
  margin-left: 6%;
}
</style>

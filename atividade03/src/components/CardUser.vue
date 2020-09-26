<template>
  <div>
    <div class="card bg-light mb-3 cardUser" style="">
      <div class="card-header"><strong>ID: </strong>{{ user.id }}</div>
      <div class="card-body">
        <p><strong>Nome: </strong>{{ user.nome }} {{ user.username }}</p>
        <p><strong>Email: </strong> {{ user.email }}</p>
        <p>
          <strong>Address: </strong> <br />
          <strong>Street: </strong> {{ user.address.street }} <br />
          <strong>Suit: </strong> {{ user.address.suite }} <br />
          <strong>City: </strong>{{ user.address.city }} <br />
          <strong>Zipcode: </strong>{{ user.address.zipcode }} <br />
          <strong>Geo </strong> - latitude: {{ user.address.geo.lat }} -
          longitude:
          {{ user.address.geo.lng }}
        </p>

        <p><strong>Phone: </strong>{{ user.phone }}</p>
        <p><strong>Website: </strong>{{ user.website }}</p>
        <p>
          <strong>Company: </strong>name: {{ user.company.name }} - Catchphrase:
          {{ user.company.catchPhrase }} - Bs: {{ user.company.bs }}
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CardUser",
  props: {
    user: {},
  },
};
</script>

<style scoped>
.cardUser {
  width: 18rem;
  height: 35rem;
  margin-left: 30%;
}
</style>

<template>
  <div>
    <div style="display: flex; flex-wrap: wrap">
      <CardUser
        v-for="(user, index) in users"
        :key="user.id"
        v-show="index < 5"
        :user="user"
      />
    </div>
    <button @click="fetchUsers">Fetch Users</button>
  </div>
</template>

<script>
import CardUser from "@/components/CardUser.vue";

export default {
  name: "Users",
  components: {
    CardUser,
  },
  data() {
    return {
      users: [],
      baseURI: "https://jsonplaceholder.typicode.com/users",
    };
  },
  methods: {
    fetchUsers: function () {
      this.$http.get(this.baseURI).then((result) => {
        this.users = result.data;
      });
    },
  },
};
</script>

<template>
  <table class="table table-striped">
    <caption class="text-end mx-5">
      {{
        counter
      }}
      Registro(s).
    </caption>
    <thead>
      <tr class="text-center">
        <th scope="col">Nome</th>
        <th scope="col">Sigla</th>
        <th scope="col">Ação</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(data, index) in units" :key="data._id">
        <td class="text-center">{{ data.name }}</td>
        <td class="text-center">{{ data.symbol }}</td>
        <td class="text-center">
          <button
            id="buttonAlter"
            class="buttons btn btn-warning justify-content-center"
            @click="setUnit(data)"
          >
            Alterar
          </button>
          <button
            id="buttonDelete"
            class="buttons btn btn-danger justify-content-center"
            @click="deleteUnit(data, index)"
          >
            Remover
          </button>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: 'UnitTable',

  computed: {
    units() {
      return this.$store.state.units.units
    },

    counter() {
      return this.$store.state.units.units.length
    },
  },

  methods: {
    setUnit(value) {
      this.$store.dispatch('units/setUnit', value)
    },

    deleteUnit(data, index) {
      const isDelete = confirm(
        `Deseja realmente apagar a unidade "${data.name}"?`
      )

      if (isDelete)
        this.$store.dispatch('units/deleteUnit', {
          unit: data,
          position: index,
        })
    },
  },
}
</script>

<style>
.buttons {
  width: 80px;
  height: 35px;
  text-align: center;
  padding: 0;
  margin: 0;
}
</style>

<template>
  <table class="table table-striped">
    <caption>
      {{
        counter
      }}
      Registro(s).
    </caption>
    <thead>
      <tr class="text-center">
        <th scope="col">Nome</th>
        <th scope="col">Descrição</th>
        <th scope="col">Unidade</th>
        <th scope="col">Ação</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(data, index) in rawMaterials" :key="data._id">
        <td class="text-center">{{ data.name }}</td>
        <td class="text-center">{{ data.description }}</td>
        <td class="text-center">{{ data.unit }}</td>

        <td class="text-center">
          <button
            id="buttonAlter"
            class="buttons btn btn-warning justify-content-center"
            @click="setRawMaterial(data)"
          >
            Alterar
          </button>
          <button
            id="buttonExcluir"
            class="btn btn-danger buttons"
            @click="deleteRawMaterial(data, index)"
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
  name: 'RawMaterialTable',

  computed: {
    rawMaterials() {
      return this.$store.state.rawMaterials.rawMaterials
    },
    counter() {
      return this.$store.state.rawMaterials.rawMaterials.length
    },
  },

  methods: {
    setRawMaterial(value) {
      this.$store.dispatch('rawMaterials/setRawMaterial', value)
    },

    deleteRawMaterial(data, index) {
      const isDelete = confirm(
        `Deseja realmente apagar a matéria prima "${data.name}"?`
      )

      if (isDelete)
        this.$store.dispatch('rawMaterials/deleteRawMaterial', {
          rawMaterial: data,
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

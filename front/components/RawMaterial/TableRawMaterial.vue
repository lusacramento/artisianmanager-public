<template>
  <table class="table table-sm">
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
            class="btn btn-alter btn-sm justify-content-center"
            @click="setRawMaterial(data)"
          >
            Alterar
          </button>
          <button
            class="btn btn-sm btn-delete justify-content-center"
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

<style></style>

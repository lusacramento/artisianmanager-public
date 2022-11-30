<template>
  <form action="" method="post">
    <div class="mb-3">
      <label for="raw-name" class="form-label">Nome</label>
      <input
        id="raw-name"
        v-model="name"
        type="text"
        class="form-control"
        required
      />
    </div>
    <div class="mb-3">
      <label for="raw-description" class="form-label">Descrição</label>
      <input
        id="raw-description"
        v-model="description"
        type="text"
        class="form-control"
        required
      />
    </div>
    <SelectUnit />
    <div class="mb-3 text-center">
      <button
        type="submit"
        class="btn btn-send justify-content-center"
        @click="send"
      >
        Enviar
      </button>
      <button
        type="reset"
        class="btn btn-clear justify-content-center"
        @click="clear"
      >
        Limpar
      </button>
    </div>
  </form>
</template>

<script>
// import SelectUnit from './SelectUnit.vue'
export default {
  name: 'RawMaterialForm',
  computed: {
    name: {
      get() {
        return this.$store.state.rawMaterials.rawMaterial.name
      },
      set(value) {
        this.$store.dispatch('rawMaterials/setName', value)
      },
    },

    description: {
      get() {
        return this.$store.state.rawMaterials.rawMaterial.description
      },
      set(value) {
        this.$store.dispatch('rawMaterials/setDescription', value)
      },
    },
  },
  methods: {
    send() {
      this.$store.dispatch('rawMaterials/send')
    },

    clear() {
      window.location.reload()
    },
  },
}
</script>

<style></style>

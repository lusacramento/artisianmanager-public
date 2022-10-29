<template>
  <form action="" method="post">
    <div class="mb-3">
      <label for="unit-name" class="form-label">Nome</label>
      <input
        id="unit-name"
        v-model="name"
        required
        type="text"
        class="form-control"
      />
    </div>
    <div class="mb-3">
      <label for="unit-symbol" class="form-label">Sigla</label>
      <input
        id="unit-symbol"
        v-model="symbol"
        required
        type="text"
        class="form-control"
      />
    </div>
    <div class="mb-3">
      <button
        type="submit"
        class="btn btn-send justify-content-center"
        @click="insertUnit"
      >
        Enviar
      </button>
    </div>
  </form>
</template>

<script>
export default {
  name: 'UnitForm',

  computed: {
    name: {
      get() {
        return this.$store.state.units.unit.name
      },
      set(value) {
        this.$store.dispatch('units/setName', value)
      },
    },

    symbol: {
      get() {
        return this.$store.state.units.unit.symbol
      },
      set(value) {
        this.$store.dispatch('units/setSymbol', value)
      },
    },
  },

  methods: {
    insertUnit() {
      this.$store.dispatch('units/postUnit')
    },
  },
}
</script>

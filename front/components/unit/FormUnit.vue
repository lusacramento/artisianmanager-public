<template>
  <form action="" method="post">
    <div class="mb-3">
      <label for="unit-name" class="form-label">Nome</label>
      <input
        id="unit-name"
        v-model="name"
        type="text"
        class="form-control"
        minlength="1"
        maxlength="20"
        required
      />
    </div>
    <div class="mb-3">
      <label for="unit-symbol" class="form-label">Sigla</label>
      <input
        id="unit-symbol"
        v-model="symbol"
        class="form-control"
        type="text"
        minlength="1"
        maxlength="6"
        required
      />
    </div>
    <div class="mb-3">
      <button
        type="submit"
        class="btn btn-send justify-content-center"
        @click="send"
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
    send() {
      this.$store.dispatch('units/send')
    },
  },
}
</script>

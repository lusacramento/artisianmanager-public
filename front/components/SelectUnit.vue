<template>
  <div class="mb-3">
    <label for="raw-unit">Unidade</label>
    <select
      id="raw-unit"
      v-model="unit"
      class="form-select select"
      name="raw-unit"
      aria-describedby="unitHelp"
    >
      <option selected value="0">Escolha uma opção</option>
      <option
        v-for="data in units"
        :key="data._id"
        :value="data.symbol"
        class="opacity-25"
      >
        ({{ data.symbol }}) {{ data.name }}
      </option>
    </select>
    <div id="unitHelp" class="form-text">
      <nuxt-link to="/units" target="_blank">cadastrar...</nuxt-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SelectUnit',
  data() {
    return {
      unit: '0',
    }
  },

  computed: {
    units: {
      get() {
        return this.$store.state.units.units
      },
    },

    counter() {
      return this.$store.state.units.units.length
    },
  },

  watch: {
    unit(newUnit) {
      this.$store.dispatch('rawMaterials/setUnit', newUnit)
      this.$store.dispatch('recipes/setUnit', newUnit)
    },
  },

  created() {
    this.$store.dispatch('units/getUnits')
  },
}
</script>

<style></style>

<template>
  <div>
    <h1>Unidade</h1>
    <div class="container-fluid">
      <div class="row d-flex">
        <div class="col-12 col-lg-4">
          <FormUnit />
        </div>
        <div class="col-12 col-lg-8">
          <TableUnit />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TableUnit from '~/components/Unit/TableUnit.vue'
import FormUnit from '~/components/Unit/FormUnit.vue'
export default {
  name: 'UnitPage',
  components: { FormUnit, TableUnit },
  data() {
    return {
      count: 0,
    }
  },

  created() {
    // Get database.
    this.$store.dispatch('units/getUnits')
  },
}
</script>

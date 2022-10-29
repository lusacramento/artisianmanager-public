<template>
  <div>
    <h1>Unidade</h1>
    <div class="container-fluid">
      <div class="row d-flex justify-content-around align-items-center">
        <div class="col-12 col-lg-2">
          <FormUnit />
        </div>
        <div class="col-12 col-lg-7">
          <TableUnit />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TableUnit from '~/components/unit/TableUnit.vue'
import FormUnit from '~/components/unit/FormUnit.vue'
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

<script setup lang="ts">
import { useForm, useField } from 'vee-validate';
import * as zod from 'zod';
import { toTypedSchema } from "@vee-validate/zod";

const validationSchema = toTypedSchema(
  zod.object({
    fullName: zod.string().nonempty('Field is required'),
    email: zod.string().nonempty('Field is required').email({ message: 'Field must be a valid email'}),
    reason: zod.array(zod.string()).nonempty('Please select at least one reason')
  })
);

const { handleSubmit, errors } = useForm({
  validationSchema,
});

const { value: fullName } = useField('fullName');
const { value: email } = useField('email');
const { value: reason } = useField('reason');

const onSubmit = handleSubmit(async values => {
  let response = await fetch('/api/customers/vip-form', {
    method: "POST",
    body: JSON.stringify(values, null, 2),
  });
  if (response.status === 204) {
    alert("Form processed");
  } else {
    alert(JSON.stringify(response, null, 2));
  }
});
</script>

<template>
  <main class="container">
    <h2>VIP Form</h2>
    <form class="container">
      <fieldset>
        <legend>
          Please fill in this form for more information
        </legend>
        <div class="mb-3">
          <label class="form-label">
            Contact Name
          </label>
          <input
              v-model="fullName"
              name="fullName"
              class="form-control"
              placeholder="Enter your full name..."  />
          <span class="error-message">{{ errors.fullName }}</span>
        </div>
        <div class="mb-3">
          <label class="form-label">
            Email Address
          </label>
          <input
              v-model="email"
              name="email"
              type="email"
              class="form-control"
              placeholder="Enter your email address..." />
          <span class="error-message">{{ errors.email }}</span>
        </div>

        <div class="mb-3">
          <label class="form-label">
            Reason for joining the VIP program?
          </label>
          <select
              v-model="reason"
              name="reason"
              multiple="multiple"
              class="form-control">
            <option value="One">
              ONE!
            </option>
            <option value="Two">
              Two!
            </option>
          </select>
          <span class="error-message">{{errors.reason}}</span>
        </div>

        <div class="mb-3 btn-group">
          <button @click="onSubmit" type="button" class="btn btn-primary">OK</button>
        </div>
      </fieldset>
    </form>

    <div class="container">
      {{ fullName }}
      {{ email }}
      {{ reason }}
      {{ errors }}
    </div>

  </main>
</template>

<style lang="scss">
h1 {
  color: green;

  &:hover {
    color: greenyellow;
  }
}
</style>

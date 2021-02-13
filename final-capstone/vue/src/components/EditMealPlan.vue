<template>
  <div class="meal-plan-edit">
    <table>
      <thead>
        <tr>
          <th colspan="8" class="mealPlanTableTitleHeader">
            <h2 class="mealPlanTableTitle">{{ oneMealPlan.name }}</h2>
          </th>
        </tr>
        <tr>
          <th></th>
          <th>Monday</th>
          <th>Tuesday</th>
          <th>Wednesday</th>
          <th>Thursday</th>
          <th>Friday</th>
          <th>Saturday</th>
          <th>Sunday</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th class="breakfast">Breakfast</th>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal"  v-model="monBreakfast">
                  <option>{{ this.mealPlan[0].mealName }}</option>
                  <option
                    :value="{ id: meal.mealId }"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal" v-model="tueBreakfast">
                  <option>{{ this.mealPlan[3].mealName }}</option>
                  <option
                    :value="{ id: meal.mealId }"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal" v-model="wedBreakfast">
                  <option>{{ this.mealPlan[6].mealName }}</option>
                  <option
                    :value="{ id: meal.mealId }"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal" v-model="thuBreakfast">
                  <option>{{ this.mealPlan[9].mealName }}</option>
                  <option
                    :value="{ id: meal.mealId }"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal" v-model="friBreakfast">
                  <option>{{ this.mealPlan[12].mealName }}</option>
                  <option
                    :value="{ id: meal.mealId }"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal" v-model="satBreakfast">
                  <option>{{ this.mealPlan[15].mealName }}</option>
                  <option
                    :value="{ id: meal.mealId }"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal" v-model="sunBreakfast">
                  <option>{{ this.mealPlan[18].mealName }}</option>
                  <option
                    :value="{ id: meal.mealId }"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
            </div>
          </td>
        </tr>
      </tbody>
      <tbody>
        <th class="lunch">Lunch</th>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="monLunch">
                <option>{{ this.mealPlan[1].mealName }}</option>
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="tueLunch">
                <option>{{ this.mealPlan[4].mealName }}</option>
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="wedLunch">
                <option>{{ this.mealPlan[7].mealName }}</option>
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="thuLunch">
                <option>{{ this.mealPlan[10].mealName }}</option>
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal"  v-model="friLunch">
                <option>{{ this.mealPlan[13].mealName }}</option>
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="satLunch">
                <option>{{ this.mealPlan[16].mealName }}</option>
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="sunLunch">
                <option>{{ this.mealPlan[19].mealName }}</option>
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
          </div>
        </td>
      </tbody>
      <tbody>
        <th class="dinner">Dinner</th>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="monDinner">
                <option>{{ this.mealPlan[2].mealName }}</option>
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="tueDinner">
                <option>{{ this.mealPlan[5].mealName }}</option>
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="wedDinner">
                <option>{{ this.mealPlan[8].mealName }}</option>
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="thuDinner">
                <option>{{ this.mealPlan[11].mealName }}</option>
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="friDinner">
                <option>{{ this.mealPlan[14].mealName }}</option>
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key= "meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="satDinner">
                <option>{{ this.mealPlan[17].mealName }}</option>
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" ref="sunDinner">
                <option selected="selected">{{ this.sunDinner.mealName }} </option>
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
          </div>
        </td>
      </tbody>
      <div class="save-meal">
        <button class="btn3" v-on:click.prevent="saveEditedMealPlan()">Save</button>
      </div>
    </table>
  </div>
</template>

<script>
import mealService from "../services/MealService";

export default {
  data() {
    return {
      mealPlan: [],
      oneMealPlan: {},
      allMyMeals: [],
      userId: this.$store.state.user.id,
      monBreakfast: "",
      monLunch: "",
      monDinner: "",
      tueBreakfast: "",
      tueLunch: "",
      tueDinner: "",
      wedBreakfast: "",
      wedLunch: "",
      wedDinner: "",
      thuBreakfast: "",
      thuLunch: "",
      thuDinner: "",
      friBreakfast: "",
      friLunch: "",
      friDinner: "",
      satBreakfast: "",
      satLunch: "",
      satDinner: "",
      sunBreakfast: "",
      sunLunch: "",
      sunDinner: "",
    };
  },
  created() {
    mealService.getSchedule(this.$route.params.id).then((response) => {
      this.mealPlan = response.data;
        this.monBreakfast = response.data[0];
        this.monLunch = response.data[1];
        this.monDinner = response.data[2]
        this.tueBreakfast = response.data[3];
        this.tueLunch = response.data[4];
        this.tueDinner = response.data[5];
        this.wedBreakfast = response.data[6];
        this.wedLunch = response.data[7];
        this.wedDinner = response.data[8];
        this.thuBreakfast = response.data[9];
        this.thuLunch = response.data[10];
        this.thuDinner = response.data[11];
        this.friBreakfast = response.data[12];
        this.friLunch = response.data[13];
        this.friDinner = response.data[14];
        this.satBreakfast = response.data[15];
        this.satLunch = response.data[16];
        this.satDinner = response.data[17]
        this.sunBreakfast = response.data[18];
        this.sunLunch = response.data[19];
        this.sunDinner = response.data[20];
        

      console.log(this.monDinner);

    });
    mealService.getMealPlan(this.$route.params.id).then((response) => {
      if (response.status === 200) {
        this.oneMealPlan = response.data;
      }
    });
    mealService
      .getMyMeals(this.userId)
      .then((response) => {
        this.allMyMeals = response.data;
      })
      .catch((error) => {
        console.error(error + " can't get my meals.");
      });

  },
  methods: {
    saveEditedMealPlan(){
      console.log(this.$refs.sunDinner.value ); //this was displaying name
      const scheduleToEditArray = [
        {
            scheduleId: this.mealPlan[0].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.monBreakfast.id,
            dayOfWeek: "Monday",
            timeOfDay: "Breakfast",
          },
          {
            scheduleId: this.mealPlan[1].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.monLunch.id,
            dayOfWeek: "Monday",
            timeOfDay: "Lunch",
          },
          {
            scheduleId: this.mealPlan[2].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.monDinner.id,
            dayOfWeek: "Monday",
            timeOfDay: "Dinner",
          },
          {
            scheduleId: this.mealPlan[3].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.tueBreakfast.id,
            dayOfWeek: "Tuesday",
            timeOfDay: "Breakfast",
          },
          {
            scheduleId: this.mealPlan[4].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.tueLunch.id,
            dayOfWeek: "Tuesday",
            timeOfDay: "Lunch",
          },
          {
            scheduleId: this.mealPlan[5].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.tueDinner.id,
            dayOfWeek: "Tuesday",
            timeOfDay: "Dinner",
          },
          {
            scheduleId: this.mealPlan[6].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.wedBreakfast.id,
            dayOfWeek: "Wednesday",
            timeOfDay: "Breakfast",
          },
          {
            scheduleId: this.mealPlan[7].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.wedLunch.id,
            dayOfWeek: "Wednesday",
            timeOfDay: "Lunch",
          },
          {
            scheduleId: this.mealPlan[8].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.wedDinner.id,
            dayOfWeek: "Wednesday",
            timeOfDay: "Dinner",
          },
          {
            scheduleId: this.mealPlan[9].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.thuBreakfast.id,
            dayOfWeek: "Thursday",
            timeOfDay: "Breakfast",
          },
          {
            scheduleId: this.mealPlan[10].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.thuLunch.id,
            dayOfWeek: "Thursday",
            timeOfDay: "Lunch",
          },
          {
            scheduleId: this.mealPlan[11].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.thuDinner.id,
            dayOfWeek: "Thursday",
            timeOfDay: "Dinner",
          },
          {
            scheduleId: this.mealPlan[12].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.friBreakfast.id,
            dayOfWeek: "Friday",
            timeOfDay: "Breakfast",
          },
          {
            scheduleId: this.mealPlan[13].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.friLunch.id,
            dayOfWeek: "Fiday",
            timeOfDay: "Lunch",
          },
          {
            scheduleId: this.mealPlan[14].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.friDinner.id,
            dayOfWeek: "Friday",
            timeOfDay: "Dinner",
          },
          {
            scheduleId: this.mealPlan[15].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.satBreakfast.id,
            dayOfWeek: "Saturday",
            timeOfDay: "Breakfast",
          },
          {
            scheduleId: this.mealPlan[16].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.satLunch.id,
            dayOfWeek: "Saturday",
            timeOfDay: "Lunch",
          },
          {
            scheduleId: this.mealPlan[17].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.satDinner.id,
            dayOfWeek: "Saturday",
            timeOfDay: "Dinner",
          },
          {
            scheduleId: this.mealPlan[18].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.sunBreakfast.id,
            dayOfWeek: "Sunday",
            timeOfDay: "Breakfast",
          },
          {
            scheduleId: this.mealPlan[19].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.sunLunch.id,
            dayOfWeek: "Sunday",
            timeOfDay: "Lunch",
          },
          {
            scheduleId: this.mealPlan[20].scheduleId,
            mealPlanId: this.$route.params.id,
            mealId: this.$refs.sunDinner,
            dayOfWeek: "Sunday",
            timeOfDay: "Dinner",
          },
      ];

      mealService.editSchedule(scheduleToEditArray).then(response => {
        if(response.status === 200){
          alert("Meal plan has been updated!");
        }
      });
    }
  }
};
</script>

<style>
</style>
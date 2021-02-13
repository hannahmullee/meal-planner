<template>
  <div class="meal-plan">
    <caption class="mealPlanCaption">
      <div class="meal-plan-name">
        <label class="mealPlanLabel">Name your meal plan: </label>
        <input
          class="meal-plan-box"
          v-model="mealPlan.name"
          type="text"
          id="mealPlanName"
          name="mealPlanName"
        />

        <button
          class="save-meal-plan-name"
          v-on:click="
            saveMealPlanName();
            showTable = true;
          "
          v-show="showTable === false"
        >
          Save Meal Plan Name
        </button>
        <br />
        <br />
      </div>
    </caption>
    <table class="table" v-show="showTable === true">
      <thead>
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
                <select id="meal" name="meal" v-model="monBreakfast">
                  <option
                    :value="{ id: meal.mealId }"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                    <!-- {{ meal.mealId }} -->
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal" v-model="tueBreakfast">
                  <option
                    :value="{ id: meal.mealId }"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal" v-model="wedBreakfast">
                  <option
                    :value="{ id: meal.mealId }"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal" v-model="thuBreakfast">
                  <option
                    :value="{ id: meal.mealId }"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal" v-model="friBreakfast">
                  <option
                    :value="{ id: meal.mealId }"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal" v-model="satBreakfast">
                  <option
                    :value="{ id: meal.mealId }"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal" v-model="sunBreakfast">
                  <option
                    :value="{ id: meal.mealId }"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
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
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
            <br />
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="tueLunch">
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
            <br />
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="wedLunch">
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
            <br />
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="thuLunch">
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
            <br />
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="friLunch">
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
            <br />
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="satLunch">
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
            <br />
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="sunLunch">
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
            <br />
          </div>
        </td>
      </tbody>
      <tbody>
        <th class="dinner">Dinner</th>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="monDinner">
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
            <br />
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="tueDinner">
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
            <br />
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="wedDinner">
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
            <br />
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="thuDinner">
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
            <br />
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="friDinner">
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
            <br />
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="satDinner">
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
            <br />
          </div>
        </td>
        <td>
          <div class="dropdown">
            <div class="dropdown-content">
              <select id="meal" name="meal" v-model="sunDinner">
                <option
                  :value="{ id: meal.mealId }"
                  v-for="meal in allMyMeals"
                  :key="meal.mealId"
                >
                  {{ meal.name }}
                </option>
              </select>
            </div>
            <br />
          </div>
        </td>
      </tbody>
    <div class="buttonDiv">
      <div class="save-meal" v-on:click="saveMealRow()">
        <button class="btn3">Save</button>
      </div>
    </div>
    </table>
    <br />
  </div>
</template>

<script>
import MealService from "../services/MealService";

export default {
  data() {
    return {
      showTable: false,
      allMyMeals: [],
      userId: this.$store.state.user.id,
      scheduleRow: {
        mealPlanId: "",
        mealId: "",
        schedule: [21],
      },
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

      mealPlan: {
        mealPlanId: "",
        name: "",
        userId: this.$store.state.user.id,
      },
    };
  },
  created() {
    MealService.getMyMeals(this.userId)
      .then((response) => {
        this.allMyMeals = response.data;
      })
      .catch((error) => {
        console.error(error + " cannot get my meals");
      });
  },
  methods: {
    saveMealPlanName() {
      MealService.addMealPlanName(this.mealPlan).then((response) => {
        if (response.status === 201) {
          alert("Meal Plan Saved!");
          this.setMealPlanId();
        }
      });
    },
    setMealPlanId() {
      MealService.getMealPlanIdWithName(this.mealPlan.name).then((response) => {
        this.mealPlan.mealPlanId = response.data;
      });
    },
    saveMealRow() {
      const scheduleArray = [
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.monBreakfast.id,
          dayOfWeek: "Monday",
          timeOfDay: "Breakfast",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.monLunch.id,
          dayOfWeek: "Monday",
          timeOfDay: "Lunch",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.monDinner.id,
          dayOfWeek: "Monday",
          timeOfDay: "Dinner",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.tueBreakfast.id,
          dayOfWeek: "Tuesday",
          timeOfDay: "Breakfast",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.tueLunch.id,
          dayOfWeek: "Tuesday",
          timeOfDay: "Lunch",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.tueDinner.id,
          dayOfWeek: "Tuesday",
          timeOfDay: "Dinner",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.wedBreakfast.id,
          dayOfWeek: "Wednesday",
          timeOfDay: "Breakfast",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.wedLunch.id,
          dayOfWeek: "Wednesday",
          timeOfDay: "Lunch",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.wedDinner.id,
          dayOfWeek: "Wednesday",
          timeOfDay: "Dinner",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.thuBreakfast.id,
          dayOfWeek: "Thursday",
          timeOfDay: "Breakfast",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.thuLunch.id,
          dayOfWeek: "Thursday",
          timeOfDay: "Lunch",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.thuDinner.id,
          dayOfWeek: "Thursday",
          timeOfDay: "Dinner",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.friBreakfast.id,
          dayOfWeek: "Friday",
          timeOfDay: "Breakfast",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.friLunch.id,
          dayOfWeek: "Fiday",
          timeOfDay: "Lunch",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.friDinner.id,
          dayOfWeek: "Friday",
          timeOfDay: "Dinner",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.satBreakfast.id,
          dayOfWeek: "Saturday",
          timeOfDay: "Breakfast",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.satLunch.id,
          dayOfWeek: "Saturday",
          timeOfDay: "Lunch",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.satDinner.id,
          dayOfWeek: "Saturday",
          timeOfDay: "Dinner",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.sunBreakfast.id,
          dayOfWeek: "Sunday",
          timeOfDay: "Breakfast",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.sunLunch.id,
          dayOfWeek: "Sunday",
          timeOfDay: "Lunch",
        },
        {
          mealPlanId: this.mealPlan.mealPlanId,
          mealId: this.sunDinner.id,
          dayOfWeek: "Sunday",
          timeOfDay: "Dinner",
        },
      ];

      console.log("mealplan");
      console.log(scheduleArray[20].dayOfWeek);
      console.log(scheduleArray);
      MealService.addMealToPlan(scheduleArray).then((response) => {
        if (response.status === 201) {
          console.log("Meal added to plan!");
          this.scheduleRow = response.data;
          console.log(scheduleArray);
          alert("Meal Plan Saved!");
          window.location.reload();
        }
      });
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Raleway&display=swap");

th {
  font-family: Raleway;
}

.mealPlanLabel {
  font-family: Raleway;
  font-size: 1.5rem;
}

.buttonDiv {
  margin-left: auto;
  margin-right: auto;
}
/* .buttonDiv:hover {
  background-color: #ffffff;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
} */

.meal-plan {
  display: flex;
  flex-direction: column;
}

.meal-plan-name {
  margin-left: auto;
  margin-right: auto;
}

.table {
  margin-left: auto;
  margin-right: auto;
  width: 80%;
}
/* .btn1 {
  font-family: Raleway, Verdana, Geneva, Tahoma, sans-serif;
  font-weight: bold;
}
.btn2 {
  font-family: Raleway, Verdana, Geneva, Tahoma, sans-serif;
  font-weight: bold;
} */
.btn3 {
  font-family: Raleway, Verdana, Geneva, Tahoma, sans-serif;
  font-weight: bold;
  font-size: 2vh;
}

/* .btn3:hover{
  cursor: pointer;
  font-family: Raleway;
} */

.add-ingredients {
  display: flex;
  width: 250px;
  height: 50px;
  font-size: 2vh;
  background: #f3f0f1;
  margin-bottom: 25px;
  border-radius: 32px;
  text-align: center;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
  margin-left: auto;
  margin-right: auto;
}

.clear-meal {
  display: flex;
  width: 200px;
  height: 50px;
  font-size: 2vh;
  background: #f3f0f1;
  margin-bottom: 25px;
  border-radius: 32px;
  text-align: center;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
  margin-left: auto;
  margin-right: auto;
}
.save-meal {
  display: flex;
  width: 200px;
  height: 50px;
  font-size: 2vh;
  background: #f3f0f1;
  margin-bottom: 25px;
  border-radius: 32px;
  text-align: center;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
  margin-left: auto;
  margin-right: auto;
}

.save-meal:hover {
  background-color: #ffffff;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
}

.edit-meal {
  display: flex;
  width: 200px;
  height: 50px;
  font-size: 2vh;
  background: #f3f0f1;
  margin-bottom: 25px;
  border-radius: 32px;
  text-align: center;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
  margin-left: auto;
  margin-right: auto;
}

select {
  width: 180px;
  height: 35px;
}

thead {
  font-size: 25px;
}
.breakfast {
  font-size: 25px;
}
.lunch {
  font-size: 25px;
}
.dinner {
  font-size: 25px;
}

.meal-plan-box {
  font-size: 2vh;
}

.save-meal-plan-name {
  font-family: Raleway, Verdana, Geneva, Tahoma, sans-serif;
  font-size: 2vh;
}
</style>
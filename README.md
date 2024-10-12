# Library_Manangement_System
Prerequisites
* Mysql local server
* Java 17 sdk
* npm installed

<h2>BACKEND</h2>

* Pull the Repo.
* Change the mysql username password in application.properties.
* run the seed_database.txt script in mysql local server.
* Do a clean compile install on springboot
* run the application.
* swagger-ui : http://localhost:8080/swagger-ui/index.html

<h2>FRONT END</h2>

* Pull the front end code.
* install node modules using npm install or npm i
* install tailwindCSS using npm install -D tailwindcss postcss autoprefixer
* npx tailwindcss init -p
* replace content of tailwind.config.js with
```
/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {},
  },
  plugins: [],
}
```
* Add Tailwind to your index.css
```
@tailwind base;
@tailwind components;
@tailwind utilities;
```
* install shadcn/ui
* npm install -g shadcn-ui
* npx shadcn init
* npx shadcn add alert button card input table toast toaster
* npm run dev

  For any issues check official guide of tailwindcss and shadcn
  tailwind - https://tailwindcss.com/docs.
  shadcn -  https://ui.shadcn.com/docs/installation/vite


/** @type {import("tailwindcss").Config} */
module.exports = {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx}",
    "./components/**/*.{js,ts,jsx,tsx}"
  ],
  theme: {
    extend: {
      blur: {
        xxs: "1px",
        xs: "2px"
      },
      screens: {
        "pixel": { "min": "360px", "max": "824px" }
      }
    }
  },
  plugins: []
};
var gulp = require("gulp");
var csscomb = require("gulp-csscomb");
var autoprefixer = require("autoprefixer");
var stylelint = require("stylelint");
var postcss = require("gulp-postcss");

gulp.task("default", function() {
  return gulp
    .src("./TransVideo/css/style.css")
    .pipe(csscomb())
    .pipe(postcss([autoprefixer(), stylelint()]))
    .pipe(gulp.dest("./dist/css"));
});

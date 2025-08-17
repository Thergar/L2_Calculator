rootProject.name = "L2_Calculator"

include(":backend", "gui")

project(":backend").projectDir = file("Lineage2Calculator")
project(":gui").projectDir = file("Lineage2CalculatorGUI")


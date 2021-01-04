#!/bin/bash

cd ConfigurationService && chmod +x build.sh && ./build.sh
cd ../EurekaService && chmod +x build.sh && ./build.sh
clc
clear all
x=(-100:001:100)';
y = x>=0;
ramp=x.*y;
plot(x,ramp)
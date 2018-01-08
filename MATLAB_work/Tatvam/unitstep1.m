clc
clear all
i=0;
x=(-100:0.00001:100);

unitstep = x>=0;

plot(x,unitstep)
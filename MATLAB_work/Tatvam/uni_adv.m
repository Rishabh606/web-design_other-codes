clc
clear all
close all
x=(-2:.0001:2);
y=(x+1/2)>=0;
z= (x-1/2)>=0;
r=y-z;
plot(x,r)
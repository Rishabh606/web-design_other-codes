clc
clear all
close all
x=(-20:.01:6*pi);
unitstep= x>=0;
y=3*cos(2*pi*x+pi/3).*unitstep;
plot(x,y)
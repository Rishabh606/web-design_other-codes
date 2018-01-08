function [ y ] = unitstep3( a,b )
%UNTITLED5 Summary of this function goes here
%   Detailed explanation goes here
t = (-4:0.01:4);
y= a*t+b<=0;
end


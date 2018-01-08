function [ y ] = ramp2( n )
%UNTITLED3 Summary of this function goes here
%   Detailed explanation goes here
unitstep= n>=0;
y= (n).*unitstep;

end


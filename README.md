# Attacker App

Attacker App is a minimal Android application skeleton intended for **security research and testing**. It serves as a foundation for experimenting with **Android inter-process communication (IPC) attacks**, including forging and manipulating interactions with other apps via exported components.

This project does **not** include real attack payloads or automation. Instead, it provides a clean foundation that researchers can extend for controlled experiments.
Furthermore, it contains some example attack vectors used to complete the hextree.io Android Security course.

## Purpose

The goal of this app is to help developers and security researchers:

- Evaluate how Android apps handle **untrusted IPC input**
- Test security controls around **exported components**
- Identify misconfigurations or missing protections in IPC entry points
- Build reproducible proof-of-concept research tools

## IPC Mechanisms in Scope

This project may be extended to research vulnerabilities involving:

- **Intents** (explicit and implicit)
- **Activities**
- **Services** (started and bound)
- **Broadcast Receivers**
- **Content Providers**
- Binder-based IPC interactions
- Permission and signature enforcement issues

## What This App Is

- A **skeleton / template** Android app
- A test harness for Android IPC security research
- A controlled environment for building PoCs

## What This App Is Not

- Not a ready-to-use exploitation framework
- Not an automated attack tool
- Not intended for unauthorized use

## Features

- Minimal Android app structure
- Placeholder components for crafting IPC requests
- Easily extensible architecture for research use
- No bundled exploits, payloads, or scanners

## Requirements

- Android Studio
- Android device or emulator
- Target applications intended for **authorized testing only**

## Typical Research Areas

- Exported Activities, Services, and Receivers
- Insecure IPC entry points
- Missing permission checks
- Improper intent validation
- Binder interface exposure
- Content Provider access control flaws

## Usage

This project is intentionally minimal. Researchers are expected to:

- Extend the codebase for specific experiments
- Use test targets they own or have permission to analyze
- Pair this app with intentionally vulnerable apps for learning

## Ethical & Legal Notice

⚠️ **For educational and research purposes only.**

You must have explicit authorization before testing any application you do not own.  
Misuse of this project may violate laws, policies, or ethical standards.

The author(s) assume **no responsibility** for misuse or damage caused by this software.

## Contributing

Contributions that improve structure, clarity, or research value are welcome.  
Please do not submit real-world exploit payloads.

## License

This project is licensed under the **MIT License** – see the [LICENSE](LICENSE) file for details.
